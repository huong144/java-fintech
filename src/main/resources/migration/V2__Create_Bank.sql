CREATE TABLE bank (
    id INT PRIMARY KEY AUTO_INCREMENT,
    userId int NULL,
    accountNumber VARCHAR(255)  NULL,
    bankName VARCHAR(255)  NULL,
    ownerName VARCHAR(255)  NULL,
    createdAt datetime(6) NOT NULL DEFAULT current_timestamp(6),
    updatedAt datetime(6) NOT NULL DEFAULT current_timestamp(6)
);