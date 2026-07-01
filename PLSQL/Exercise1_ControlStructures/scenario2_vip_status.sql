DECLARE
    CURSOR c_customers IS
        SELECT CustomerID, Name, Balance FROM Customers;
    v_IsVIP BOOLEAN;
BEGIN
    FOR rec IN c_customers LOOP
        IF rec.Balance > 10000 THEN
            v_IsVIP := TRUE;
            DBMS_OUTPUT.PUT_LINE('Customer ' || rec.Name || ' (ID: ' || rec.CustomerID || ') is now VIP.');
        ELSE
            v_IsVIP := FALSE;
            DBMS_OUTPUT.PUT_LINE('Customer ' || rec.Name || ' (ID: ' || rec.CustomerID || ') is not VIP.');
        END IF;
    END LOOP;
END;
/
