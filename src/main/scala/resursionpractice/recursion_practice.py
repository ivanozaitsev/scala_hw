# Recursion task
def is_palindrome(text: str) -> bool:
    def get_clean_text(text):
        return ''.join(char.lower() for char in text if char.isalnum())

    def check_palindrome(clean_text):
        if len(clean_text) <= 1:
            return True
        if clean_text[0] == clean_text[-1]:
            return check_palindrome(clean_text[1:-1])
        return False

    clean_text = get_clean_text(text)
    return check_palindrome(clean_text)


test_strings = ['A palindrome', '12/21/33 12:21', 'A man, a plan, a canal – Panama']
for item in test_strings:
    print(is_palindrome(item))


# Tail recursion task
def is_palindrome_tail(text: str) -> bool:
    def get_clean_text(text, clean_text=""):
        if not text:
            return clean_text
        char = text[0]
        if char.isalnum():
            clean_text += char.lower()
        return get_clean_text(text[1:], clean_text)

    def check_palindrome(clean_text, start=0, end=None):
        if end is None:
            end = len(clean_text) - 1

        if start >= end:
            return True
        if clean_text[start] == clean_text[end]:
            return check_palindrome(cleaned_text, start + 1, end - 1)
        return False

    cleaned_text = get_clean_text(text)
    return check_palindrome(cleaned_text)


test_strings = ['A palindrome', '12/21/33 12:21', 'A man, a plan, a canal – Panama']
for item in test_strings:
    print(is_palindrome_tail(item))

