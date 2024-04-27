```text
src/main
└─java
    ├─base
    │  ├─controller
    │  ├─model
    │  └─view
    └─lotto...
```

![image](https://github.com/spring-templates/java-lotto/assets/96914905/e10e0b27-1ed9-4c53-be1a-98c7af46573f)

# base.model.Schema

내용은 없다.

단순히 `generic abstract class`를 통해 컨벤션을 강제하는 목적으로 사용된다.

필요하다면 이를 `InputSchema`, `OutputSchema` 등으로 세분화하여 기반 추상 클래스를 재정의해도 좋다.

```java
public interface Schema {

}
```

# base.model.Validator

다양한 형식의 DTO를 검증하기 위한 `Validator` 클래스의 명세이다.

명세를 준수하기 위해 DTO는 반드시 Schema를 구현해야 한다.

```java
public interface Validator<T extends Schema> {
    void validate(T input) throws IllegalArgumentException;
}
```

# base.view.View

`View`는 MVC에서 하나의 역할을 담당한다.

따라서, SRP 원칙을 강제하고자 추상 클래스로 정의했다.

`View`에 대한 조작이 이루어지는 `Controller` 패키지 내부의 클래스에서 이를 참조하게 된다.

```java
public abstract class View<T extends Schema> {

    public void header() {
        System.out.println();
    }

    public void render(T t) {
        System.out.println(t);
    }
}
```

# base.controller.Converter

`Schema` A를 B로 변환하는 역할을 담당한다.

이는 주어진 lotto 내의 모든 문제를 DTO를 변환하는 작업으로 추상화한 결과이다.

개발자는 두 개의 서로 다른 `Schema`를 변환하는 추상 메서드 `convert()`를 재정의하는 것에만 집중하면 된다.

```java
public abstract class Converter<IN extends Schema, OUT extends Schema> {
    private final View<OUT> view;

    public Converter(
            View<OUT> view
    ) {
        this.view = view;
    }

    public final OUT tryConvert(IN input) {
        OUT res = convert(input);
        if (view != null) {
            view.render(res);
        }
        return res;
    }

    protected abstract OUT convert(IN in);
}
```
