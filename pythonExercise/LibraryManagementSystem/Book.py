class Book:
    def __init__(self, title, author, isbn):
        self._title = title
        self._author = author
        self._isbn = isbn
        self._availability = True  

    # Getters
    def get_title(self):
        return self._title

    def get_author(self):
        return self._author

    def get_isbn(self):
        return self._isbn

    def is_available(self):
        return self._availability

    # Setter for availability
    def set_availability(self, status):
        self._availability = status
