package data;

import java.util.Arrays;

final public class DigitalSignature {
    private final byte[] sign;

    public DigitalSignature(byte[] sign) throws Exception {
        if(sign == null){
            throw new Exception("DigitalSignature error");
        }
        this.sign = sign;
    }

    public byte[] getDigitalsignature() {
        return sign;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DigitalSignature sign1 = (DigitalSignature) o;
        return sign.equals(sign1.sign);
    }

    @Override
    public int hashCode() { return sign.hashCode(); }

    @Override
    public String toString() {
        return "DigitalSignature{" + "digitalsignature='" + Arrays.toString(sign) + '\'' + '}';
    }

}
