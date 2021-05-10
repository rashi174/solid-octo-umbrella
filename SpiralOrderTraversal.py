class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        order = []
        while matrix:
            #first row
            order.extend(matrix.pop(0))  
            
            #Last Coloumn
            if matrix and matrix[0]:
                for i in range(len(matrix)):
                    order.append(matrix[i].pop())
            
            #Last row
            if matrix:
                order.extend(matrix.pop()[::-1])
            
            #Last Coloumn
            if matrix and matrix[0]:
                for i in matrix[::-1]:
                    order.append(i.pop(0))
        return order
                                