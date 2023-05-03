import React from "react";
import { useParams } from "react-router-dom";
import ReactPlayer from "react-player";

const Trailer = () => {
  let params = useParams();
  const key = params.yID;
  return (
    <div>
      {key != null ? (
        <ReactPlayer
          className="react-player-container"
          controls={true}
          playing={true}
          url={`https://www.youtube.com/watch?v=${key}`}
          width="100%"
          height="80vh"
        />
      ) : null}
    </div>
  );
};

export default Trailer;
