CREATE TABLE account (
    id INT PRIMARY KEY AUTO_INCREMENT,
    totalAmountLimit VARCHAR(255)  NULL,
    creditLimit VARCHAR(255)  NULL,
    mortgageLimit VARCHAR(255)  NULL,
    amount VARCHAR(255)  NULL,
    amountBlock VARCHAR(255)  NULL,
    availableAmount VARCHAR(255)  NULL,
    amountLoan VARCHAR(255)  NULL,
    amountInvestment VARCHAR(255)  NULL,
    status VARCHAR(255)  NULL,
    createdAt datetime(6) NOT NULL DEFAULT current_timestamp(6),
    updatedAt datetime(6) NOT NULL DEFAULT current_timestamp(6)
);