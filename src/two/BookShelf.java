package two;


import java.lang.reflect.Method;

// 使用 Book 注解
public class BookShelf {
    @Book(value = "西游记", price = 998, authors = {"吴承恩", "白求恩"})
    public void showBook() {
        // 使用反射获取注解信息
        try {
            Method method = this.getClass().getMethod("showBook");
            Book book = method.getAnnotation(Book.class);

            System.out.println("书名是：" + book.value());
            System.out.println("价格是：" + book.price());
            System.out.print("作者是：");
            for (String author : book.authors()) {
                System.out.print(author + " ");
            }
            System.out.println();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf();
        bookShelf.showBook();
    }
}
