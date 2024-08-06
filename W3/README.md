The Bank Schema
For the remainder of the book, you use a group of tables that model a community bank.
Some of the tables include Employee, Branch, Account, Customer, Product, and Transac
tion. The entire schema and example data should have been created when you followed
the final steps at the beginning of the chapter for loading the MySQL server and generating the sample data. To see a diagram of the tables and their columns and relationships, see Appendix A.
Table 2-10 shows all the tables used in the bank schema along with short definitions.
Table 2-10. Bank schema definitions
Table name Definition
Account A particular product opened for a particular customer
Branch A location at which banking transactions are conducted
Business A corporate customer (subtype of the Customer table)
Customer A person or corporation known to the bank
Department A group of bank employees implementing a particular banking function
Employee A person working for the bank
Individual A noncorporate customer (subtype of the Customer table)
Officer A person allowed to transact business for a corporate customer
Product A banking service offered to customers
Product_type A group of products having a similar function
Transaction A change made to an account balance
