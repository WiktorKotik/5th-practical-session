# ComposeTutorial — практическое занятие 5

**Создание интерфейса для телефона и планшета** (МДК.01.03 «Разработка мобильных приложений»).
Приложение на Kotlin + Jetpack Compose: экран **«Помощь тренера»** фитнес-приложения **Pulse Fit**
(прототип из практической работы 1): чат со списком сообщений, которые разворачиваются по нажатию с анимацией.

## Что выполнено

| Задание | Что сделано | Где смотреть |
|---|---|---|
| 1. Настройка среды | Проект с поддержкой Compose, шаблон «Empty Activity», Kotlin, minSdk 31 | `app/build.gradle.kts` |
| 2. Текстовый элемент | `@Composable`-функция `MessageCard`, `@Preview` | `MessageCard.kt` |
| 3. Макет | `Row` + `Column`, `Image` (фото профиля), `Spacer`, модификаторы (`size`, `clip`, `border`, `padding`) | `MessageCard.kt` |
| 4. Material Design 3 | `MaterialTheme`, `Surface`, `colorScheme`, `typography`, `shapes`, светлая и тёмная тема | `ui/theme/`, `MessageCard.kt` |
| 5. Списки и анимация | `LazyColumn` + `items`, состояние `remember` / `mutableStateOf`, `animateColorAsState`, `animateContentSize` | `Conversation.kt`, `MessageCard.kt` |
| 6. Оформление под тему | Тема из макета Pulse Fit: тёмный фон, оранжевый акцент `#FF6B2C`, бирюзовые детали, логотип с пульсом в шапке и на иконке приложения | `ui/theme/`, `MainActivity.kt`, `res/` |

**Телефон и планшет:** если ширина экрана меньше 600 dp — список в один столбец (`LazyColumn`),
на планшете — адаптивная сетка из нескольких колонок (`LazyVerticalGrid`).
В Android Studio в окне Preview доступны превью: светлая тема, тёмная тема, телефон, планшет.

## Структура проекта

```
app/src/main/java/com/example/composetutorial/
├── MainActivity.kt      # Activity, экран ChatScreen (шапка с логотипом, заголовок, список)
├── MessageCard.kt       # карточка сообщения (макет, Material, анимация)
├── Conversation.kt      # список сообщений (LazyColumn / LazyVerticalGrid)
├── Message.kt           # модель данных
├── SampleData.kt        # пример набора сообщений
└── ui/theme/            # Color.kt, Type.kt, Shape.kt, Theme.kt
```

## Как запустить

1. Android Studio → **File → Open** → выбрать папку проекта, дождаться Gradle Sync.
2. Выбрать эмулятор (телефон или планшет) или подключённое устройство, Android 12 (API 31) и выше.
3. Нажать **Run ▶**.

По умолчанию приложение тёмное, как в макете (константа `FORCE_DARK_THEME` в `MainActivity.kt`; светлая тема тоже реализована).

Использованные версии: AGP 8.7.3, Kotlin 2.0.21, Compose BOM 2024.10.01, Material 3, compileSdk 35.
