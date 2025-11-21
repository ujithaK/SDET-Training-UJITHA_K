from Person import Person  # Optional base class

class Member(Person):
    def __init__(self, name, member_id):
        super().__init__(name)
        self._member_id = member_id
        self._borrowed_books = []
        print(f"Member: Name-{self._name}, ID-{self._member_id} created")

    def get_member_id(self):
        return self._member_id

    def get_borrowed_books(self):
        return self._borrowed_books

    def borrow_book(self, book):
        if book in self._borrowed_books:
            print("Book already borrowed.")
        else:
            self._borrowed_books.append(book)
            book.set_availability(False)
            print(f"{self._name} borrowed '{book.get_title()}'.")



