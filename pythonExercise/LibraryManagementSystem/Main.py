from Book import Book
from Member import Member
from library import Library
from Person import Person  # optional base class

# Create library
lib = Library()

# Add books
book1 = Book("Premalekha", "Munimanikyam", "ISBN001")
book2 = Book("Me Before You", "Jojo Moyes", "ISBN002")
book3 = Book("It Ends With Us", "Colleen Hoover", "ISBN003")

lib.add_book(book1)
lib.add_book(book2)
lib.add_book(book3)

# Add members
member1 = Member("Ujitha", "M001")
member2 = Member("Manasa", "M002")

lib.add_member(member1)
lib.add_member(member2)

# Lending books
lib.lend_book("ISBN001", "M001")
lib.lend_book("ISBN002", "M002")
lib.lend_book("ISBN001", "M002") 

# Returning books
lib.return_book("ISBN001", "M001")

lib.lend_book("ISBN001", "M002")  

lib.search_book("prema")


