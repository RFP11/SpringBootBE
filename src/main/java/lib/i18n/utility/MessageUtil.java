package lib.i18n.utility;

import lib.i18n.L10n;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MessageUtil {
    private final MessageSource messageSource;

    private String get(Locale locale, String code, Object... args) {
        return messageSource.getMessage(code, args, code, locale);
    }

    public String get(String code, Object... args) {
        Locale locale = LocaleContextHolder.getLocale();

        return this.get(locale, code, args);
    }

    public String get(@Nullable L10n locale, String code, Object... args) {
        var selectedLocale = locale == null ? L10n.DEFAULT : locale;
        return this.get(selectedLocale.getLocale(), code, args);
    }
}
