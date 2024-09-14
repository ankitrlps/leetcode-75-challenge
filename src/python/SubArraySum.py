class SubArraySum:
    
    def subarraySum(self, nums: list[int], k: int) -> int:
        res = 0
        currSum = 0
        prefixSum = {0: 1}
        
        for n in nums:
            currSum += n
            diff = currSum - k
            
            res += prefixSum.get(diff, 0)
            prefixSum[currSum] = 1 + prefixSum.get(currSum, 0)
    
        return res
    

obj = SubArraySum()
print(obj.subarraySum([1,1,1], 2))
    
            
            
            