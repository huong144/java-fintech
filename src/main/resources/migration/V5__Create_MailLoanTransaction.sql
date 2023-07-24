CREATE TABLE main_loan_transaction (
    id INT PRIMARY KEY AUTO_INCREMENT,
    mainLoanId int  NULL,
    borrowerId int  NULL,
    statusChange VARCHAR(255)  NULL,
    createdAt datetime(6) NOT NULL DEFAULT current_timestamp(6),
    updatedAt datetime(6) NOT NULL DEFAULT current_timestamp(6)
);