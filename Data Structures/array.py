# Automatic Resizing Array Implemented in Python
class Array:

    # Set initial capacity and load percentage to resize vector
    def __init__(self, capacity=16, load_size=0.75):
        if capacity == 0:
            raise Exception("Bad parameter...")
        self.vector = []
        self.capacity = capacity
        self.load_size = load_size

        # len(array) cost is O(1)
        # self.size = ...
    
    # double size of vector, and in any other language copy contents over
    def __autoresize__(self):
        if len(self.vector) > self.load_size * self.capacity:
            self.capacity = self.capacity * 2
        elif len(self.vector) * 4 <= self.capacity:
            self.capacity = self.capacity // 2
    
    def size(self):
        return len(self.vector)

    def get_capacity(self):
        return self.capacity
    
    def is_empty(self):
        return len(self.vector) == 0

    def get(self, index):
        return self.vector[index]

    def push(self, elem):
        self.vector.append(elem)
        self.__autoresize__()
    
    def pop(self):
        elem = self.vector[len(self.vector)-1]
        del self.vector[len(self.vector)-1]
        self.__autoresize__()
        return elem
    
    def insert(self, index, elem):
        new_vector = []
        for i in range(index):
            new_vector[i] = self.vector[i]

        new_vector[index] = elem

        for i in range(index+1, len(self.vector)):
            new_vector[i] = self.vector[i-1]
        
        self.__autoresize__()
    
    def delete(self, index):
        elem = self.vector[index]
        for i in range(index, len(self.vector)-1):
            self.vector[i] = self.vector[i+1]
        self.__autoresize__()
        return elem
    
    def find(self, elem):
        for i in range(len(self.vector)):
            if self.vector[i] == elem:
                return i
        return -1
    
