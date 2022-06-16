public class SqlJoins {

    String naturalKey = "real world data: ssn's DL#s";
    String surrogateKey = "Artificially created by an application to make it unique";
        String primaryKey = "Columns that uniquely identify the row(cannot be duplicated).";
        String foreignKey = "" +
                "A key that is in other tables used to reference PK in source table";
        String cardinality = "Max number of times one entity can be associated with instances" +
                " in a related entity.";

             String oneToOne = "EX: A student can have one student id.";
             String oneToManyNoXTable = "EX: A school can have multiple classes but a class can only have one school";
             String manyToManyNeedsXTable = "EX a class can have multiple students and a student can have" +
                     "multiple classes" +
                     "Require a join table with it's own keys to connect the two";

             //JOINS
    String innerJoin = "Connects two tables using their keys" +
                     "EX: SELECT *" +
                     "FROM one " +
                     "INNER JOIN two ON one.key = two.key";
    String leftOuterJoin = "Grabs all records from left table regardless of match(including NULLs)" +
                            "EX: SELECT" +
                            "FROM one" +
                            "LEFT JOIN two ON one.key = two.key";
    String rightOuterJoin = "Grabs all records from right table regardless of match(including NULLs)" +
            "EX: SELECT" +
            "FROM one" +
            "RIGHT JOIN two ON one.key = two.key";
    String Unions = "Joins two queries together from the same table" +
            "Tables must have same amt of columns." +
            "Unions add rows to the selected ";




}
