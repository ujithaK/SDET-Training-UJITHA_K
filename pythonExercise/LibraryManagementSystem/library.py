from Book import Book
from Member import Member


class Library:
    def __init__(self):
        self.books = []
        self.members = []

#Function for adding books
    def add_book(self, book):
        self.books.append(book)
        print(f"Book '{book.get_title()}' added to library.")
#Remove Books
    def remove_book(self, isbn):
        for book in self.books:
            if book.get_isbn() == isbn:
                self.books.remove(book)
                print(f"Book '{book.get_title()}' removed from library.")
                return
        print("Book not found.")
#Adding members
    def add_member(self, member):
        self.members.append(member)

#Returning book
    def return_book(self, isbn, member_id):
        book = None
        for b in self.books: 
            if b.get_isbn() == isbn: #it will check with isbn only if isbn matches it will enter if block
                book = b
                break
        if book is None:
            print("Book not found.")
            return

        member = None
        for m in self.members:
            if m.get_member_id() == member_id:
                member = m
                break
        if member is None:
            print("Member not found.")
            return

        member.return_book(book)
#Function to search books
    def search_book(self, keyword): 
        found_books = []
        keyword = keyword.lower()
        for book in self.books:
            if keyword in book.get_title().lower() or keyword in book.get_author().lower():
                found_books.append(book)
        return found_books
    #Lending book
    def lend_book(self, isbn, member_id):
        book = None
        for b in self.books:
            if b.get_isbn() == isbn:
                book = b
                break
        if book is None:
            print("Book not found.")
            return

        member = None
        for m in self.members:
            if m.get_member_id() == member_id:
                member = m
                break
        if member is None:
            print("Member not found.")
            return

        if not book.is_available():
            print("Book is currently unavailable.")
            return

        member.borrow_book(book)
