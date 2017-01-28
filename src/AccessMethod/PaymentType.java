package AccessMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * Enum for {@link PaymentType}
 */
public enum PaymentType {

    /**
     * One-time/scheduled payment type.
     */
    ONE_TIME_PAYMENT(1L, "SCHED_PYMNT"),
    
    /**
     * Reimbursement payment type.
     */
    REIMBURSEMENT(2L, "RT_RMBRS"),

    /**
     * Real-time payment type.
     */
    REAL_TIME_PAYMENT(3L, "RT_PYMNT"),

    /**
     * Auto payment type.
     */
    AUTO_PAYMENT(4L, "AUTO_PYMNT"),

    /**
     * Reversal payment type.
     */
    PAYMENT_REVERSAL(5L, "PYMNT_RVRSL"),

    /**
     * Reimbursement reversal payment type.
     */
    REIMBURSEMENT_REVERSAL(6L, "RMBRS_RVRSL");

    /**
     * The payment type id as in database.
     */
    private Long id;

    /**
     * The payment type constant value as in database.
     */
    private String value;

    /**
     * Map store for {@link PaymentType}.
     */
    private static final Map<String, PaymentType> PAYMENT_TYPE_MAP = new HashMap<>();

    /**
     * Populates the PAYMENT_TYPE_MAP.
     */
    static {
        for (PaymentType paymentType : PaymentType.values()) {
            PAYMENT_TYPE_MAP.put(paymentType.value, paymentType);
        }
    }

    /**
     * Instantiates a new {@link PaymentType}.
     * 
     * @param id the id
     * @param value the payment type constant value
     */
    private PaymentType(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    /**
     * Returns the {@link PaymentType} enum from the value.
     * 
     * @param value the value
     * @return the {@link PaymentType} enum
     */
    public static PaymentType fromValue(String value) {
        PaymentType paymentType = PAYMENT_TYPE_MAP.get(value);
        if (paymentType == null) {
            throw new IllegalArgumentException("Unknown payment constant value [" + value + "] ");
        }

        return paymentType;
    }
    /**
     * Returns the {@link PaymentType} enum from the key.
     *
     * @param id the key id
     * @return the {@link PaymentType} enum
     */
    public static PaymentType fromKey(Long id) {
        for (PaymentType paymentType : PAYMENT_TYPE_MAP.values()) {
            if(paymentType.id.equals(id)) {
                return paymentType;
            }
        }
        // if no matched key is found, throw an exception.
        throw new IllegalArgumentException("Unknown payment type id [" + id + "] ");
    }
    /**
     * Get the id.
     * 
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Get the value of the enum type.
     * 
     * @return the value of the enum type
     */
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getId() + " : " + getValue();
    }
}