CREATE TABLE loan_contract (
    id INT PRIMARY KEY AUTO_INCREMENT,
    mainLoanId int  NULL,
    loanContractNumber VARCHAR(255)  NULL,
    borrowerId int  NULL,
    lenderId int  NULL,
    amount VARCHAR(255)  NULL,
    status VARCHAR(255)  NULL,
    createdAt datetime(6) NOT NULL DEFAULT current_timestamp(6),
    updatedAt datetime(6) NOT NULL DEFAULT current_timestamp(6)
);