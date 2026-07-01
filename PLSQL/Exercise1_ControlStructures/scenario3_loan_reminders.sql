DECLARE
    CURSOR c_loans IS
        SELECT l.LoanID, l.EndDate, c.Name, c.CustomerID
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
    FOR rec IN c_loans LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || rec.Name || ', your loan (ID: ' || rec.LoanID || ') is due on ' || TO_CHAR(rec.EndDate, 'DD-MON-YYYY') || '. Please ensure timely payment.');
    END LOOP;
END;
/
