#!/usr/bin/env python3

import aiy.audio
import aiy.cloudspeech
import aiy.voicehat
from googletrans import Translator


def main():
    recognizer = aiy.cloudspeech.get_recognizer()
    recognizer.expect_phrase('turn off the light')
    recognizer.expect_phrase('turn on the light')
    recognizer.expect_phrase('blink')

    button = aiy.voicehat.get_button()
    led = aiy.voicehat.get_led()
    aiy.audio.get_recorder().start()

    while True:
        print('Press the button and speak')
        button.wait_for_press()
        print('Listening...')
        text = recognizer.recognize()
        translator = Translator()
        if not text:
            print('Sorry, I did not hear you.')
        else:
            print('You said "', text, '"')
            text_translated = translator.translate(text, dest='en', src='auto')
            print('Translation"', text_translated.text, '"')
            aiy.audio.say(text_translated.text,volume=100)
##            aiy.audio.say('You said "' + text + '"', volume=5)
            if 'turn on the light' in text:
                led.set_state(aiy.voicehat.LED.ON)
            elif 'turn off the light' in text:
                led.set_state(aiy.voicehat.LED.OFF)
            elif 'blink' in text:
                led.set_state(aiy.voicehat.LED.BLINK)
            elif 'repeat after me' in text:
                # Remove "repeat after me" from the text to be repeated
                to_repeat = text.replace('repeat after me', '', 1)
                aiy.audio.say(to_repeat,volume=100)
            elif 'goodbye' in text:
                break


if __name__ == '__main__':
    main()
