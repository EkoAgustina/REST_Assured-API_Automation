@echo off

::===============================Configuration==================================
::Enter Test Cases, If single test case : TCLG001 and if multiple test cases: TCLG001,TCLG002,TCREG001
set testCases=TCLG001

::==============================================================================

if defined testCases (
    call mvn clean test -Dgroups=%testCases%
)

::allure generate --clean && allure open