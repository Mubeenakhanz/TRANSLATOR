#!/bin/bash --rcfile

source /etc/bash.bashrc
source ~/.bashrc

cat /etc/aiyprojects.info

cd ~/AIY-voice-kit-python
source env/bin/activate

echo "Dev terminal is ready!"
src/translator.py
