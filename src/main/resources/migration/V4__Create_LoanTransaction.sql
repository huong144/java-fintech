CREATE TABLE loan_transaction (
    id INT PRIMARY KEY AUTO_INCREMENT,
    loanId int  NULL,
    borrowerId int  NULL,
    lenderId int  NULL,
    amount VARCHAR(255)  NULL,
    statusChange VARCHAR(255)  NULL,
    createdAt datetime(6) NOT NULL DEFAULT current_timestamp(6),
    updatedAt datetime(6) NOT NULL DEFAULT current_timestamp(6)
);