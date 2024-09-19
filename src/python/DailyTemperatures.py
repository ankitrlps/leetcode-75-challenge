class DailyTemperatures:
        def dailyTemperatures(self, temperatures: list[int]) -> list[int]:
            res = [0] * len(temperatures)
            stack = []

            for i, t in enumerate(temperatures):
                while stack and stack[-1][1] < t:
                    index, temp = stack.pop()
                    res[index] = (i - index)
                stack.append([i, t])
        
            return res
        
obj = DailyTemperatures()
print(obj.dailyTemperatures([73,74,75,71,69,72,76,73]))