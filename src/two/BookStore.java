package two;
//..
@Book3(value = "红楼梦", authors = {"曹雪芹"}, price = 998)
public class BookStore {

    @Book3(value = "西游记", authors = {"吴承恩"})
    public void buyBook() {
        // 方法体
    }

    @Book3(value = "理想国", price = 999, authors = {"柏拉图"})
    public void sellBook() {
        // 方法体
    }
}

