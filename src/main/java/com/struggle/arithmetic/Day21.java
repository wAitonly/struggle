package com.struggle.arithmetic;

/**
 * 175. 组合两个表
 * @author zhaobenquan
 */
public class Day21 {
    public static void main(String[] args) {
        System.out.println(2 << 10);
    }

    /**
     * 表1: Person
     * +-------------+---------+
     * | 列名         | 类型     |
     * +-------------+---------+
     * | PersonId    | int     |
     * | FirstName   | varchar |
     * | LastName    | varchar |
     * +-------------+---------+
     * PersonId 是上表主键
     *
     * 表2: Address
     * +-------------+---------+
     * | 列名         | 类型    |
     * +-------------+---------+
     * | AddressId   | int     |
     * | PersonId    | int     |
     * | City        | varchar |
     * | State       | varchar |
     * +-------------+---------+
     * AddressId 是上表主键
     *
     * 编写一个 SQL 查询，满足条件：无论 person 是否有地址信息，都需要基于上述两表提供 person 的以下信息：
     * FirstName, LastName, City, State
     */
    public static void one() {
        String sql = "select \n" +
                "p.FirstName, p.LastName, a.City, a.State\n" +
                "from Person p\n" +
                "left join Address a on p.PersonId = a.PersonId";
    }

}
