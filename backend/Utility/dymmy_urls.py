import random
import string


def generate_sub_path(size):
    letters = string.ascii_lowercase
    return ''.join(random.choice(letters) for i in range(size))


class GenerateDummyUrls:
    def __init__(self):
        self.domains = ['dummy1domain.com', 'dummy2domain.com', 'dummy3domain.com']

    def generate_url(self):
        domain_index = random.randint(0, len(self.domains)-1)
        dummy_url = 'https://'
        dummy_url += self.domains[domain_index]
        for i in range(random.randint(1, 4)):
            dummy_url += generate_sub_path(random.randint(5, 10))
        return dummy_url


durl = GenerateDummyUrls()
with open('dummy_url.csv', 'w') as file:
    for _ in range(1000000):
        file.writelines(durl.generate_url()+'\n')
