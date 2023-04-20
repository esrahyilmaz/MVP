f7::
sleep, 2000
send {tab}{tab}{enter}
sleep, 1000
run, C:\\Users\\mishrbik\\Desktop\\HomeDepoLogin.ahk
sleep, 1000
Loop
{
#Singleinstance force
Process, Close, Autohotkey.exe
}