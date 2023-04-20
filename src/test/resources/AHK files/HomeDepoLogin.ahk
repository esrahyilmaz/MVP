f5::
send {tab}{tab}{tab}{tab}{tab}{tab}{tab}{tab}{tab}{tab}{enter}
sleep, 5000
send {tab}{tab}{enter}
sleep, 50000
WinMaximize, A
sleep, 1000
send KHASA{tab}		;username of sanu  and press tab
sleep, 1000
send test123{tab}	;password
sleep, 1000
send stp{tab}		;Home
sleep, 1000
send wqa{tab}{tab}{enter}	;Processing	and click on Login		
sleep, 15000
MouseMove,539,436	;Edit case
sleep, 1000
click,539,436         ; click = for clicking 1 time , click,2 = is for click two times 

Loop
{
#Singleinstance force
Process, Close, Autohotkey.exe
}

return
