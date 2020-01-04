package com.aop.tx;

/**
 * @author JiangBaoyong
 * @date 2020/01/04
 **/
public interface BookShopDao {
    /**
     * 根据书号查询书剩余数量
     * @param isbn
     * @return
     */
    int getBookNumberByIsbn(String isbn);

    /**
     *新增书本
     * @param book
     * @return
     */
    void insertBook(Book book);

    /**
     * 更新减少书本数量
     * 实际中书本数量不可能小于0，所以当剩余数量为0或结果小于0就会操作失败
     * @param isbn
     * @param num
     */
    void updateBookNum(String isbn, int num);
}
