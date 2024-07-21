export const action = async ({ request }) => {
  const shopify = context.shopify;
  const api = context.api;

  const { shop, session, topic } = await shopify.authenticate.webhook(request);

  console.log(`Received ${topic} webhook for ${shop}`);

  // Webhook requests can trigger multiple times and after an app has already been uninstalled.
  // If this webhook already ran, the session may have been deleted previously.
  if (session) {
    console.error("fixme: handle app uninstalled");
    await shopify.sessionStorage.deleteSession(session.id);
  }

  return new Response();
};
