# Library Catalog

## Цель

Разобраться с архитектурой проекта, научиться читать и анализировать чужой код, находить баги и добавлять новый
функционал.

## Описание слоёв и их ответственность

### model

- **Book.java** — модель книги: название, автор, жанр, год публикации, уникальный идентификатор.
- **BookCategory.java** — перечисление возможных жанров (FICTION, NONFICTION, FANTASY, SCIENCE и т. д.).

### repository

- **BookRepository.java** — простой репозиторий для хранения книг (на коллекциях).
    - `addBook(Book book)`
    - `removeBook(String title)`
    - `List<Book> getAllBooks()`
    - `List<Book> findByTitle(String title)`

### service

- **BookService.java** — бизнес-логика:
    - Работа с репозиторием
    - Поиск по нескольким критериям
    - Предотвращение дубликатов
    - Регистронезависимый поиск

### Main

- **Main.java** — точка входа, демонстрация использования библиотеки

---

## Основная функциональность

1. Добавление новой книги в каталог
2. Удаление книги по названию
3. Отображение всего списка книг
4. Поиск книг по названию

---

## Баги

1. **Поиск не учитывает регистр** — `"harry potter"` и `"Harry Potter"` ищутся по-разному
2. **Можно добавить дубликаты** — одна и та же книга может добавляться несколько раз (нет проверки уникальности)

---

## Дополнительная функциональность

### Расширенный поиск

Добавить возможность искать книги по:

- Автору
- Жанру
- Году публикации
- Или по комбинации нескольких параметров

Пример:

```java
List<Book> search(String title, String author, BookCategory category, Integer year)
