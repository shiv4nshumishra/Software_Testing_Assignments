function f()

Dim x
x = 1
While x <= 5
msgbox x
x = x+1
Wend

x = 1
Do
msgbox x
x = x+1
Loop until(x>5)
For i = 1 To 5 Step 1
msgbox "hello"
Next


end function
f