CREATE TABLE main_loan_contract (
    id INT PRIMARY KEY AUTO_INCREMENT,
    mainLoanContractNumber VARCHAR(255)  NULL,
    borrowerId int  NULL,
    totalAmount VARCHAR(255)  NULL,
    loanTerm VARCHAR(255)  NULL,
    loanRate VARCHAR(255)  NULL,
    fee VARCHAR(255)  NULL,
    methodPayment VARCHAR(255)  NULL,
    paymentDueDate datetime(6)  NULL,
    status VARCHAR(255)  NULL,
    createdAt datetime(6) NOT NULL DEFAULT current_timestamp(6),
    updatedAt datetime(6) NOT NULL DEFAULT current_timestamp(6)
);