package uz.smd.marketplatform.utils;

import ru.tinkoff.decoro.slots.Slot;
import ru.tinkoff.decoro.slots.SlotValidators;

/**
 * Created by Siddikov Mukhriddin on 8/20/21
 */
public final class PredefinedSlots {

    public static final Slot[] SINGLE_SLOT = new Slot[]{ru.tinkoff.decoro.slots.PredefinedSlots.any()};

    public static final Slot[] RUS_PHONE_NUMBER = {
            ru.tinkoff.decoro.slots.PredefinedSlots.hardcodedSlot('+'),
            ru.tinkoff.decoro.slots.PredefinedSlots.hardcodedSlot('9'),
            ru.tinkoff.decoro.slots.PredefinedSlots.hardcodedSlot('9'),
            ru.tinkoff.decoro.slots.PredefinedSlots.hardcodedSlot('8'),
            ru.tinkoff.decoro.slots.PredefinedSlots.hardcodedSlot(' ').withTags(Slot.TAG_DECORATION),
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.hardcodedSlot(' ').withTags(Slot.TAG_DECORATION),
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.hardcodedSlot(' ').withTags(Slot.TAG_DECORATION),
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.hardcodedSlot(' ').withTags(Slot.TAG_DECORATION),
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
    };

    public static final Slot[] RUS_PASSPORT = {
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.hardcodedSlot(' '),
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
    };

    public static final Slot[] CARD_NUMBER_STANDARD = {
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.hardcodedSlot(' ').withTags(Slot.TAG_DECORATION),
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.hardcodedSlot(' ').withTags(Slot.TAG_DECORATION),
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.hardcodedSlot(' ').withTags(Slot.TAG_DECORATION),
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
    };

    public static final Slot[] CARD_NUMBER_MAESTRO = {
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.hardcodedSlot(' ').withTags(Slot.TAG_DECORATION),
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
    };

    public static final Slot[] CARD_NUMBER_STANDARD_MASKABLE = {
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
            maskableDigit(),
            maskableDigit(),
            maskableDigit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.hardcodedSlot(' ').withTags(Slot.TAG_DECORATION),
            maskableDigit(),
            maskableDigit(),
            maskableDigit(),
            maskableDigit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.hardcodedSlot(' ').withTags(Slot.TAG_DECORATION),
            maskableDigit(),
            maskableDigit(),
            maskableDigit(),
            maskableDigit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.hardcodedSlot(' ').withTags(Slot.TAG_DECORATION),
            maskableDigit(),
            maskableDigit(),
            maskableDigit(),
            maskableDigit(),
    };

    public static final Slot[] CARD_NUMBER_MAESTRO_MASKABLE = {
            ru.tinkoff.decoro.slots.PredefinedSlots.digit(),
            maskableDigit(),
            maskableDigit(),
            maskableDigit(),
            maskableDigit(),
            maskableDigit(),
            maskableDigit(),
            maskableDigit(),
            ru.tinkoff.decoro.slots.PredefinedSlots.hardcodedSlot(' ').withTags(Slot.TAG_DECORATION),
            maskableDigit(),
            maskableDigit(),
            maskableDigit(),
            maskableDigit(),
    };

    public static Slot hardcodedSlot(char value) {
        return new Slot(Slot.RULES_HARDCODED, value, null);
    }

    public static Slot digit() {
        return new Slot(null, new SlotValidators.DigitValidator());
    }

    public static Slot any() {
        return new Slot(null, new SlotValidators.GenerousValidator());
    }

    public static Slot maskableDigit() {
        return new Slot(null, new SlotValidators.MaskedDigitValidator());
    }

    private PredefinedSlots() {

    }

}
