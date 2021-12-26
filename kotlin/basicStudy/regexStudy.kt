package basicStudy

import kotlin.math.abs

private const val MIN = 8
private const val MAX = 20

// 동일한 문자, 숫자 확인
private const val CONTINUOUSNUM = """(\w)\1\1"""

// 공백확인
private const val BLANKCHECK = """(\s)"""

// 영문/ 숫자 / 특수문자 최소 최대 길이 확인 & 대소문자 구분 안함
private const val REGEX = """^((?=.*\d)(?=.*[a-zA-Z])(?=.*[\W]).{$MIN,$MAX})$"""

private val testStrings = arrayOf(
    "votmdnj&em123",
    "kjs@aldkjfklj43",
    "QBWfklj4543",
    "QBWfklj4543!!",
    "abct438983",
    "acdf@sabcer9182",
    "alfl012kdd",
    "asd@fasdf987",
    // Blank 테스트 문자열
    "xp@tmxm85 84",
    // 공백 테스트 문자열
    "",
    // 문자 길이 테스트 문자열
    "OJHDSJK@HFzDLKDJLJoiejwf42^%wij",
    "xyz47@",
    "1lkjvneim@",
    // ASCII Overflow 테스트 문자열
    "/01alkjdffn",
    "9:;aslkdjfkja2",
    "?@alakjlkiie3",
    "Z[\\ekjmvkfd4",
    "@abieofinv2",
    "89:8973589723dfasb",
    "YZ[qoeirnvk235"
)

private fun isValidPW(password: String?): Boolean {

    val isValid = false

    if (password.isNullOrBlank()) {
        println("null 또는 공백")
        return isValid
    }

    // null 체크후에 변수를 생성함으로 널 확인을 안해도됨
    val upperPW = password.uppercase()
    val lengthPW = password.length

    // 최소 최대 길이 확인
    if (lengthPW < 8 || lengthPW > 20) {
        println("길이 확인 : $lengthPW")
        return isValid
    }

    // 공백확인
    if (upperPW.matches(Regex(BLANKCHECK))) {
        println("중간에 공백 존재")
        return isValid
    }

    // 비밀번호 정규식 확인, 이경우 옳으면 true, 틀리면 false 라서 !로 convert
    if (!upperPW.matches(Regex(REGEX))) {
        println("필수 요건 충족 못함")
        return isValid
    }

    // 연속된 동일 문자 확인 3개 이상
    if (upperPW.matches(Regex(CONTINUOUSNUM))) {
        println("동일한 문자 3개이상")
        return isValid
    }

    // 연속된 숫자 확인
    val asciiArray = mutableListOf<Int>()

    // 아스키 코드의 데이터로 변환후 저장
    upperPW.forEach {
        asciiArray.add(it.code)
    }

    // 3개의 인덱스를 비교해 1, 2, 3 과 같이 연속되는 패스워드가 있는지 확인
    for (idx in 0 until asciiArray.size - 2) {
        if ((asciiArray[idx] > 47 && asciiArray[idx + 2] < 58) ||
            (asciiArray[idx] > 64 && asciiArray[idx + 2] < 91)
        ) {
            if (abs(asciiArray[idx + 2] - asciiArray[idx + 1]) == 1 &&
                abs(asciiArray[idx + 2] - asciiArray[idx]) == 2
            ) {
                println("detected: Continuous pattern : ${asciiArray[idx].toChar()}, ${asciiArray[idx + 1].toChar()}, ${asciiArray[idx + 2].toChar()}")
                return isValid
            }
        }
    }
    return isValid.not()
}


fun regexRun() {
    testStrings.forEach {
        print("$it    result : \n")
        println(isValidPW(it))
    }

}