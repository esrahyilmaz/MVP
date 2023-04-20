f4::
sleep, 3000
MouseMove,827,665
sleep, 1000
click,827,665
sleep, 1000
send Y
sleep, 1000
MouseMove,865,431
sleep, 1000
click,865,431
sleep, 1000
send Y
sleep, 1000
send {tab}{tab}{tab}{tab}{tab}{tab}{tab}{enter}

Loop
{
#Singleinstance force
Process, Close, Autohotkey.exe
}
return