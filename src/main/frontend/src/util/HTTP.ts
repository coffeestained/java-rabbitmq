import { OutgoingHttpHeaders } from "http2";

type Options = {
  url: string,
  options: {
    method: "GET" | "POST" | "PUT" | "DELETE", // * GET, POST, PUT, DELETE, etc.
    headers?: OutgoingHttpHeaders,
    body?: {},
  }
}

type formatOptions = "TEXT" | "JSON" | "BINARY" | null;

const formats = {
  "TEXT": async (obj: Response) => { return obj },
  "BINARY": async (obj: Response) => { return obj },
  "JSON": async (obj: Response) => { return await obj.json() },
  null: async (obj: Response) => { return await obj.json() },
}

/**
 * Request Function Utilizing Fetch
 * @param {string} url
 * @param {Options} options
 * @param {boolean} binary as Buffer or Json
 * @return {data}
**/
export async function request(options: Options, format: formatOptions = null) {
  const data = await fetch(
      options.url,
      {
          ...options.options as RequestInit,
      },
  );
  if (format) {
    const response = formats[format].call(data, data);
    console.log(data)
    return response;
  }
  return data;
}
