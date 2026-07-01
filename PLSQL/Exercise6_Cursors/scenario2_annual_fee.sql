DECLARE
    CURSOR ApplyAnnualFee IS
        SELECT AccountID, Balance FROM Accounts;
    v_rec ApplyAnnualFee%ROWTYPE;
    v_annual_fee NUMBER := 50;
BEGIN
    OPEN ApplyAnnualFee;
    LOOP
        FETCH ApplyAnnualFee INTO v_rec;
        EXIT WHEN ApplyAnnualFee%NOTFOUND;
        UPDATE Accounts
        SET Balance = Balance - v_annual_fee,
            LastModified = SYSDATE
        WHERE AccountID = v_rec.AccountID;
        DBMS_OUTPUT.PUT_LINE('Annual fee of ' || v_annual_fee || ' deducted from AccountID: ' || v_rec.AccountID);
    END LOOP;
    CLOSE ApplyAnnualFee;
    COMMIT;
END;
/
