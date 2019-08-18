import random

class WeightNode:
    def __init__(self, weight, key, parent):
        self.weight = weight
        self.weight_sum = weight

        # Key
        self.key = key

        # Tree
        self.parent = parent
        self.left = None
        self.right = None
        self.left_count = 0
        self.right_count = 0
    
    def push(self, weight, key):
        if not self.left:
            new_node = WeightNode(weight, key, self)
            self.left = new_node
            self.left_count = 1
        elif not self.right:
            new_node = WeightNode(weight, key, self)
            self.right = new_node
            self.right_count = 1
        elif self.left_count <= self.right_count:
            new_node = self.left.push(weight, key)
            self.left_count += 1
        else: # right_count > left_count
            new_node = self.right.push(weight, key)
            self.right_count += 1
        self.weight_sum += weight
        return new_node
    
    def update(self, weight):
        self.update_sum(weight - self.weight)
        self.weight = weight
    
    def update_sum(self, change):
        self.weight_sum += change
        if self.parent:
            self.parent.update_sum(change)
    
    def delete(self):
        # self.parent.update_sum(-self.weight)
        # if not self.right and self.left:
        #     if self.parent.left == self:
        #         self.parent.left = None
        #     else:
        #         self.parent.right = None
        # elif (not self.left or self.right_count > self.left_count):
        pass


    
    def generate(self):
        r = random.random() * self.weight_sum
        if self.left and r < self.left.weight_sum:
            return self.left.generate()
        elif self.right and ((self.left and r >= self.left.weight_sum + self.weight) or (not self.left and r >= self.weight)):
            return self.right.generate()
        else:
            return self.key


class WeightedGenerator:
    def __init__(self):
        self.keys = {}
        self.root = None
    
    def add(self, key, weight):
        new_node = None
        if not self.root:
            new_node = WeightNode(weight, key, None)
            self.root = new_node
        else:
            new_node = self.root.push(weight, key)
        
        self.keys[key] = new_node
    
    def update(self, key, weight):
        self.keys[key].update(weight)
    
    def delete(self, key):
        del self.keys[key]
        self.root = None
        for key in self.keys:
            self.add(key, self.keys[key].weight)
    
    def generate(self):
        return self.root.generate()
    
    def print(self):
        if not self.root:
            print("No keys.")
            return

        queue = []
        queue.append(self.root)
        while queue:
            node = queue.pop(0)
            print("[ " + str(node.key) + " weight: " + str(node.weight) + " weight_sum: " + str(node.weight_sum) + " ]")
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)


generator = WeightedGenerator()
generator.add("a", 1)
generator.add("b", 2)
generator.add("c", 3)
generator.add("d", 4)

generator.print()

result = {"a":0, "b":0, "c":0, "d":0}
for i in range(10000):
    result[generator.generate()] += 1
print(result)

print("\n updating weights to a:3")
generator.print()
generator.update("a", 3)

result = {"a":0, "b":0, "c":0, "d":0}
for i in range(10000):
    result[generator.generate()] += 1

print(result)
