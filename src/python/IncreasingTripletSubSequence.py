class IncreasingTripletSubSequence:
    def increasingTriplet(self, nums: list[int]) -> bool:
        a = b = float('inf')
        for num in nums:
            if num <= a:
                a = num
            elif a < num and num <= b:
                b = num
            else:
                if a < b:
                    return True
        return False

obj = IncreasingTripletSubSequence()
print(obj.increasingTriplet([20,100,10,12,5,13]))
print(obj.increasingTriplet([5,4,3,2,1]))
