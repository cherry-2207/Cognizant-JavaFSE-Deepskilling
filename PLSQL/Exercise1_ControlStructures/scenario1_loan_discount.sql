DECLARE
    v_age NUMBER;
    CURSOR c_customers IS
        SELECT CustomerID, DOB FROM Customers;
BEGIN
    FOR rec IN c_customers LOOP
        v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, rec.DOB) / 12);
        IF v_age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = rec.CustomerID;
            DBMS_OUTPUT.PUT_LINE('Discount applied for CustomerID: ' || rec.CustomerID || ' (Age: ' || v_age || ')');
        END IF;
    END LOOP;
    COMMIT;
END;
/
