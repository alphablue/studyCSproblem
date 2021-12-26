import javax.tools.ForwardingFileObject
import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class Example {
    var p: String by Delegate()
}

class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }
}

// delegates 를 사용할때 observable은 초기값을 설정 할 수 있고 이후 수정값에 대해서
// 핸들링 할 수 있는 방법을 제공해 준다.
class User {
    var name: String by Delegates.observable("<no name>") { property, oldValue, newValue ->
        println("$oldValue -> $newValue")
    }
}

var topLevelInt: Int = 0

class ClassWithDelegate(val anotherClassInt: Int)

class MyClass1(private var memberInt: Int, private val anotherClassInstance: ClassWithDelegate) {
    var delegatedToMember: Int by this::memberInt
    var delegatedToTopLevel: Int by ::topLevelInt

    val delegatedToAnotherClass: Int by anotherClassInstance::anotherClassInt
}

var MyClass1.extDelegated: Int by ::topLevelInt
var MyClass1.extProperty: Int
    get() {
        return 1000
    }
    set(value) {
        this.extProperty = value
    }


class MyClass2 {
    var newName: Int = 0

    @Deprecated("Use 'newName' instead", ReplaceWith("newName"))
    var oldName: Int by this::newName
}

class User2(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int by map
}

val user2 = User2(mapOf(
    "name" to "John Doe",
    "age" to 25
))

class Resource

class Owner {
    val valResource: Resource by ResourceDelegate()
}

class ResourceDelegate(private var resource: Resource = Resource()) {
    operator fun getValue(thisRef: Owner, property: KProperty<*>): Resource {
        return Resource()
    }

    operator fun setValue(thisRef: Owner, property: KProperty<*>, value: Any?) {
        if (value is Resource) {
            resource = value
        }
    }
}

//fun resourceDelegate(): ReadWriteProperty<Any?, Int> =
//    object : ReadWriteProperty<Any?, Int> {
//        var curValue = 0
//        override fun getValue(thisRef: Any?, property: KProperty<*>): Int = curValue
//        override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) =
//    }

fun delegateStudyRun() {
    val e = Example()

    // 값을 set 하지 않았을 때 위임의 default 값으 받음
    println(e.p)

    // 위임을 활용해 set 하면 set하는 값이 value로 넘어가는 것을 확인 할 수 있음
    e.p = "NEW"
    println()


    // observable delegate 를 사용할 수 있는 것
    val user = User()
    user.name = "first"
    user.name = "second"
    println()

    println("클래스안과 밖의 프로퍼티에 대한 위임")
    val class1 = MyClass1(11, ClassWithDelegate(5))
    println(class1.delegatedToMember)
    println(class1.delegatedToTopLevel)
    println(class1.delegatedToAnotherClass)

    // 확장 property 에도 위임을 통해서 값을 넘겨 줄 수 있음 원래는 get(), set()을 따로 설정해 줘야함함
    println(class1.extDelegated)

    // 일반적인 extension property get/set value 를 사용한것
    println(class1.extProperty)
    println()


    // deprecated 를 설정하고 그 값을 새로운 형식에 위임하는 방법
    val class2 = MyClass2()
    class2.oldName = 42
    println(class2.newName)
    println()

    // map 에 데이터를 위임으로 저장과 불러 오기 사용
    println(user2.name)
    println(user2.age)


    val regex = "(\\w)\\1\\1\\1".toRegex()
    val test = "1112222".matches(regex)
    println(test)
}
