$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("nicebank/cash_withdrawal.feature");
formatter.feature({
  "id": "cash-withdrawal",
  "description": "",
  "name": "Cash Withdrawal",
  "keyword": "Feature",
  "line": 1
});
formatter.before({
  "duration": 2668002000,
  "status": "passed"
});
formatter.before({
  "duration": 14516000,
  "status": "passed"
});
formatter.before({
  "duration": 34401000,
  "status": "passed"
});
formatter.scenario({
  "id": "cash-withdrawal;successful-withdrawal-from-an-account-in-credit",
  "description": "",
  "name": "Successful withdrawal from an account in credit",
  "keyword": "Scenario",
  "line": 2,
  "type": "scenario"
});
formatter.step({
  "name": "my account has been credited with $100.00",
  "keyword": "Given ",
  "line": 3
});
formatter.step({
  "name": "I withdraw $20",
  "keyword": "When ",
  "line": 4
});
formatter.step({
  "name": "$20 should be dispensed",
  "keyword": "Then ",
  "line": 5
});
formatter.step({
  "name": "the balance of my account should be $80.00",
  "keyword": "And ",
  "line": 6
});
formatter.match({
  "arguments": [
    {
      "val": "$100.00",
      "offset": 34
    }
  ],
  "location": "AccountSteps.My_account_has_been_credited_with_d(Money)"
});
formatter.result({
  "duration": 128315000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "20",
      "offset": 12
    }
  ],
  "location": "TellerSteps.I_withdraw_d(int)"
});
formatter.result({
  "duration": 285742000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "20",
      "offset": 1
    }
  ],
  "location": "CashSlotSteps.d_should_be_dispensed(int)"
});
formatter.result({
  "duration": 10190000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "$80.00",
      "offset": 36
    }
  ],
  "location": "AccountSteps.the_balance_of_my_account_should_be_$(Money)"
});
formatter.result({
  "duration": 1403000,
  "status": "passed"
});
formatter.after({
  "duration": 193000,
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 56362000,
  "status": "passed"
});
formatter.after({
  "duration": 868000,
  "status": "passed"
});
formatter.before({
  "duration": 6435000,
  "status": "passed"
});
formatter.before({
  "duration": 5157000,
  "status": "passed"
});
formatter.before({
  "duration": 23201000,
  "status": "passed"
});
formatter.scenario({
  "id": "cash-withdrawal;no-withdrawals-allowed-when-cashslot-faulty",
  "description": "",
  "name": "No withdrawals allowed when cashslot faulty",
  "keyword": "Scenario",
  "line": 8,
  "type": "scenario"
});
formatter.step({
  "name": "the cashslot is faulty",
  "keyword": "Given ",
  "line": 9
});
formatter.step({
  "name": "the teller will not accept withdrawal requests",
  "keyword": "Then ",
  "line": 10
});
formatter.match({
  "location": "CashSlotSteps.the_cashslot_is_faulty()"
});
formatter.result({
  "duration": 6957000,
  "status": "passed"
});
formatter.match({
  "location": "TellerSteps.noWithdrawalRequestsAccepted()"
});
formatter.result({
  "duration": 63656000,
  "status": "passed"
});
formatter.after({
  "duration": 281000,
  "status": "passed"
});
formatter.embedding("image/png", "embedded1.png");
formatter.after({
  "duration": 57815000,
  "status": "passed"
});
formatter.after({
  "duration": 379000,
  "status": "passed"
});
});