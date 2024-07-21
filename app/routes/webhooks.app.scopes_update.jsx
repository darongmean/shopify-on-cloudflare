export const action = async ({ context, request }) => {
  const shopify = context.shopify;
  const api = context.api;

  const { payload, session, topic, shop } = await shopify.authenticate.webhook(
    request
  );

  console.log(`Received ${topic} webhook for ${shop}`);
  const current = payload.current;

  if (session) {
    console.error("fixme: handle scope changes");
  }

  return new Response();
};
