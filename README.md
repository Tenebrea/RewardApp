# Стек для построения интерфейса:
- Jetpack Compose;

# Функции:
- ShareImage – функция для кнопки «Поделиться», срабатывающая при нажатии. Требует контекст приложения и Bitmap из Composable всего экрана;
- MainActivity.onCreate() – входная точка программы, в которой должен быть реализован экран;

# Ресурсы программы:
- Drawables(изображения): Кубок - name = cup;
- UiData (object): содержит переменные title (заголовок), description (описание), shareTextButton (текст кнопки);
- Цветовая гамма: MaterialTheme.ColorScheme.background (задний фон), MaterialTheme.ColorScheme.onBackground (текст на заднем фоне);

# Функционал экрана
- Содержит изображение cup;
- Содержит заголовок UiData.title;
- Содержит описание UiData.description;
- Содержит кнопку Share, которая при нажатии преобразовывает composable экрана в bitmap и передает ее в ShareImage;

# План действий:
- Взять файл MainActivity из app/src/main/java/com.example.rewardapp;
- Создать в нем функцию MainScreen(onClick: (context: Context, bitmap: Bitmap) -> Unit), которая содержит основной экран, созданный по макету, и принимает в себя функцию shareImage(context: Context, bitmap: Bitmap). Экран должен занимать весь дисплей телефона;
- Добавить MainScreen в MainActivity.onCreate() и передать в него функцию ShareImage(context: Context, bitmap: Bitmap);