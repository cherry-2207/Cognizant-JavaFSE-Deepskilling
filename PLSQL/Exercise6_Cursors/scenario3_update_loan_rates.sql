DECLARE
    CURSOR UpdateLoanInterestRates IS
        SELECT LoanID, InterestRate FROM Loans;
    v_rec UpdateLoanInterestRates%ROWTYPE;
    v_new_rate NUMBER;
BEGIN
    OPEN UpdateLoanInterestRates;
    LOOP
        FETCH UpdateLoanInterestRates INTO v_rec;
        EXIT WHEN UpdateLoanInterestRates%NOTFOUND;

        IF v_rec.InterestRate > 10 THEN
            v_new_rate := v_rec.InterestRate - 2;
        ELSIF v_rec.InterestRate > 5 THEN
            v_new_rate := v_rec.InterestRate - 1;
        ELSE
            v_new_rate := v_rec.InterestRate - 0.5;
        END IF;

        UPDATE Loans
        SET InterestRate = v_new_rate
        WHERE LoanID = v_rec.LoanID;

        DBMS_OUTPUT.PUT_LINE('LoanID: ' || v_rec.LoanID || ' | Old Rate: ' || v_rec.InterestRate || '% | New Rate: ' || v_new_rate || '%');
    END LOOP;
    CLOSE UpdateLoanInterestRates;
    COMMIT;
END;
/
