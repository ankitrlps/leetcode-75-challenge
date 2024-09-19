class DecodeString:
    def decodeString(self, s: str) -> str:
        stack = []
        for ch in s:
            if (ch == "]"):
                ss = ""
                # popping chars in stack until [ found - for multipying
                while stack[-1] != "[":
                    ss = stack.pop() + ss
                
                stack.pop() # popping [

                #grabbing the digits
                digits = ""
                while stack and stack[-1].isdigit():
                    digits = stack.pop() + digits
                
                stack.append(int(digits) * ss)

            else:
                stack.append(ch)

        return ''.join(stack)
    
obj = DecodeString()
print(obj.decodeString("3[a]2[bc]"))
print(obj.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"))
print(obj.decodeString("3[a2[c]]"))
print(obj.decodeString("100[leetcode]"))