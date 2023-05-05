const { createProxyMiddleware } = require('http-proxy-middleware');
const { env } = require('process');

const target = env.API_PORT ? `http://localhost:${env.API_PORT}` :
  env.API_URLS ? env.API_URLS.split(';')[0] : 'http://localhost:12277';

const context = [
  "/api",
];

const onError = (err, req, resp, target) => {
    console.error(`${err.message} ${req} ${resp} ${target}`);
}

module.exports = function (app) {
  const appProxy = createProxyMiddleware(context, {
    target: target,
    // Handle errors to prevent the proxy middleware from crashing when
    // the Java webserver is unavailable
    onError: onError,
    secure: false,
    // Uncomment this line to add support for proxying websockets
    //ws: true,
    headers: {
      Connection: 'Keep-Alive'
    }
  });

  app.use(appProxy);
};
