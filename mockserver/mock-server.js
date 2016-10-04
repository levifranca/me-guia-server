// Server //

const spawn = require('child_process').spawn;
// java -jar <path to mockserver-netty-3.10.4-jar-with-dependencies.jar> -serverPort <port>
const server = spawn('java', ['-jar', 'mockserver-netty-3.10.4-jar-with-dependencies.jar', '-serverPort', '1080']);

server.stdout.on('data', (data) => {
	console.log(`stdout: ${data}`);
});

server.stderr.on('data', (data) => {
	console.log(`stderr: ${data}`);
});

server.on('close', (code) => {
	console.log(`child process exited with code ${code}`);
})

// Client //
var mockServer = require('mockserver-client');
var mockServerClient = mockServer.mockServerClient;


function setupExpectations() {
	console.log('Setting up expectations');

	var expectation1 = {
		'httpRequest': {
			'method': 'GET',
			'path': '/beacon_info',
			'queryStringParameters': [
				{
				'name': 'mac_address',
				'values': [ '20:91:48:07:1D:D9' ]
				}
			]
		},
		'httpResponse': {
			'statusCode': 200,
			'headers': [
				{
					'name': 'Content-Type',
					'values': ['application/json; charset=utf-8']
				}
			],
			'body': JSON.stringify({
				sucesso:
				{
					beacons: [
						{
						id: 1,
						nome: 'Beacon Test',
						endereco_mac: 'A1:B2:C3:D4:E5:F6',
						descricao: 'Esse é um beacon de test mockado.',
						tags: ['tag1', 'tag2', 'tag3'],
						mensagem: 'Indentifiquei um beacon!',
						audio: 'http://localhost:1080/caminho/para/o/audio.mp3',
						vibrar: true,
						regiao: 10,
						ativo: true
						}
					]
				}
			})
		},
		'times': {
			'unlimited': true
		}
	};

	var expectation2 = {
		'httpRequest': {
			'method': 'GET',
			'path': '/beacon_info',
			'queryStringParameters': [
				{
				'name': 'mac_address',
				'values': [ '30:3A:64:E6:87:4A' ]
				}
			]
		},
		'httpResponse': {
			'statusCode': 200,
			'headers': [
				{
					'name': 'Content-Type',
					'values': ['application/json; charset=utf-8']
				}
			],
			'body': JSON.stringify({
				sucesso:
				{
					beacons: [
						{
						id: 2,
						nome: 'Beacon Test',
						endereco_mac: '30:3A:64:E6:87:4A',
						descricao: 'Esse é um beacon de test mockado 2.',
						tags: ['tag3'],
						mensagem: 'Indentifiquei outro beacon!',
						audio: 'http://localhost:1080/caminho/para/o/audio2.mp3',
						vibrar: false,
						regiao: 10,
						ativo: true
						}
					]
				}
			})
		},
		'times': {
			'unlimited': true
		}
	};

	mockServerClient("localhost", 1080).mockAnyResponse(expectation1);
	mockServerClient("192.168.25.23", 1080).mockAnyResponse(expectation1);

	mockServerClient("localhost", 1080).mockAnyResponse(expectation2);
	mockServerClient("192.168.25.23", 1080).mockAnyResponse(expectation2);
}


setTimeout(setupExpectations, 10 * 1000);